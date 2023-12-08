import React from 'react';
import {Form, Button} from 'react-bootstrap';
import { useState } from 'react';
import axios  from 'axios';
import { useNavigate } from 'react-router-dom';

const AddBook = () => {

    const [bookTitle, setBookTitle] = useState("");
    const [bookAuthor, setBookAuthor] = useState("");
    const [bookPrice, setBookPrice] = useState("");
    const [bookInStock, setBookInStock] = useState("");

    let navigate = useNavigate();


    const handleSubmit = async (e) => {
        e.preventDefault();

        if (validateForm) {
            const book = {
                bookTitle: bookTitle,
                bookAuthor: bookAuthor,
                bookPrice: bookPrice,
                bookInStock: bookInStock
            }

            try {
                await axios.post('http://localhost:8084/books', book);
                window.alert("Book added successfully!");
            } catch (error) {
                window.alert(error);
            }
            navigate('/books');
        } else {
            window.alert('Please enter valid information!');
        }

    };

    const validateForm = () => {
        const regex = /^\d*\.?\d{0,2}$/;
        if (regex.test(bookPrice) && bookTitle.length > 0 && bookAuthor.length > 0 && bookPrice.length > 0) {
            return true;
        } else {
            return false;
        }

    }
    return (
        <>
            <Form autocomplete="off">
                <Form.Group controlId="formBookTitle">
                    <Form.Label>Book Title</Form.Label>
                    <Form.Control type="text" placeholder="Enter book title" onChange={(e) => setBookTitle(e.target.value)}/>
                </Form.Group>
                <Form.Group controlId="formBookAuthor">
                    <Form.Label >Book Author</Form.Label >
                    <Form.Control type="text" placeholder="Enter book author" onChange={(e) => setBookAuthor(e.target.value)} />
                </Form.Group>
                <Form.Group controlId="formBookPrice">
                    <Form.Label>Book Price</Form.Label>
                    <Form.Control type="text" placeholder="Enter book price" onChange={(e) => setBookPrice(e.target.value)} />
                </Form.Group>
                <Form.Group controlId="formBookInStock">
                        <Form.Label>Book In Stock</Form.Label>
                        <Form.Control as="select" onChange={(e) => setBookInStock(e.target.value)}>
                            <option value="true">Yes</option>
                            <option value="false">No</option>
                        </Form.Control>
                    </Form.Group>
                <Button variant="primary" onClick={handleSubmit}>
                    Submit
                </Button>
            </Form>
        </>
    )
}

export default AddBook;