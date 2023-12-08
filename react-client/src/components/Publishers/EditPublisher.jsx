import React from 'react';
import { Form, Button } from 'react-bootstrap';
import { useState } from 'react';
import axios from 'axios';
import { useNavigate, useLocation } from 'react-router-dom';

const EditPublisher () => {

    let navigate = useNavigate();
    const location = useLocation();

    const publisher = location.state.publisher;
    const [publisherName, setPublisherName] = useState(publisher.publisherName);
    const [publisherAddress, setPublisherAddress] = useState(publisher.publisherAddress);
d

    const handleSubmit = async (e) => {
        e.preventDefault();
        const publisher = {
            publisherName: publisherName,
            publisherAddress: publisherAddress
        }
        try {
            await axios.put('http://localhost:8084/publisher', publisher);
            window.alert("Publisher added successfully!");
        } catch (error) {
            window.alert(error);
        }
        navigate('/publisher');
    };

    return (
        <>
            <Form autocomplete="off">
                <Form.Group controlId="formPublisherName">
                    <Form.Label>Publisher Name</Form.Label>
                    <Form.Control type="text" value={publisher.publisherName} Change={(e) => setPublisherName(e.target.value)} />
                </Form.Group>
                <Form.Group controlId="formPublisherAddress">
                    <Form.Label >Publisher Address</Form.Label >
                    <Form.Control type="text" value={publisher.publisherAddress} onChange={(e) => setPublisherAddress(e.target.value)} />
                </Form.Group>

                <Button variant="primary" onClick={handleSubmit}>
                    Submit
                </Button>
            </Form>
        </>
    )
}

export default EditPublisher