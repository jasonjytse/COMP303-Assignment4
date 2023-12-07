import {React, useEffect} from 'react';
import {Form, Button} from 'react-bootstrap';
import { useState } from 'react';
import axios  from 'axios';
import { useNavigate, useLocation } from 'react-router-dom';

const EditBook = () => {
    const location = useLocation();
    const book = location.state.book;

    const [bookTitle, setBookTitle] = useState(book.bookTitle);
    const [bookAuthor, setBookAuthor] = useState(book.bookAuthor);
    const [bookPrice, setBookPrice] = useState(book.bookPrice);
    const [bookInStock, setBookInStock] = useState(book.setBookInStock);

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
                await axios.put('http://localhost:8084/books', book);
                window.alert("Book added successfully!");
            } catch (error) {
                console.log(error);
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
                    <Form.Control type="text" value={bookTitle} onChange={(e) => setBookTitle(e.target.value)}/>
                </Form.Group>
                <Form.Group controlId="formBookAuthor">
                    <Form.Label >Book Author</Form.Label >
                    <Form.Control type="text" value={bookAuthor} onChange={(e) => setBookAuthor(e.target.value)} />
                </Form.Group>
                <Form.Group controlId="formBookPrice">
                    <Form.Label>Book Price</Form.Label>
                    <Form.Control type="text" value={bookPrice} onChange={(e) => setBookPrice(e.target.value)} />
                </Form.Group>
                <Form.Group controlId="formBookInStock">
                        <Form.Label>Book In Stock</Form.Label>
                        <Form.Control as="select" value={bookInStock ? 'true' : 'false'} onChange={(e) => setBookInStock(e.target.value)}>
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

export default EditBook;