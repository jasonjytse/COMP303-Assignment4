import React from 'react';
import {Form, Button} from 'react-bootstrap';
import { useState } from 'react';

const AddBook = () => {

    const [bookTitle, setBookTitle] = useState("");
    const [bookAuthor, setBookAuthor] = useState("");
    const [bookPrice, setBookPrice] = useState("");
    const [bookInStock, setBookInStock] = useState("");

    return (
        <>
            <Form>
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
                            <option value="">Select an option</option>
                            <option value="true">Yes</option>
                            <option value="false">No</option>
                        </Form.Control>
                    </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        </>
    )
}

export default AddBook;