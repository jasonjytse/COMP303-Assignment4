import React from 'react';
import { Form, Button } from 'react-bootstrap';
import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const AddPublisher = () => {

    let navigate = useNavigate();

    const [publisherName, setPublisherName] = useState('');
    const [publisherAddress, setPublisherAddress] = useState('');
d

    const handleSubmit = async (e) => {
        e.preventDefault();
        const publisher = {
            publisherName: publisherName,
            publisherAddress: publisherAddress
        }
        try {
            await axios.post('http://localhost:8084/publisher', publisher);
            window.alert("Publisher added successfully!");
        } catch (error) {
            console.log(error);
        }
        navigate('/publisher');
    };

    return (
        <>
            <Form autocomplete="off">
                <Form.Group controlId="formPublisherName">
                    <Form.Label>Publisher Name</Form.Label>
                    <Form.Control type="text" placeholder="Enter Publisher name" onChange={(e) => setPublisherName(e.target.value)} />
                </Form.Group>
                <Form.Group controlId="formPublisherAddress">
                    <Form.Label >Publisher Address</Form.Label >
                    <Form.Control type="text" placeholder="Enter Publisher address" onChange={(e) => setPublisherAddress(e.target.value)} />
                </Form.Group>
                <Button variant="primary" onClick={handleSubmit}>
                    Submit
                </Button>
            </Form>
        </>
    )
}

export default AddPublisher;