import React from 'react';
import { Form, Button } from 'react-bootstrap';
import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const AddMember = () => {

    let navigate = useNavigate();

    const [membershipType, setMembershipType] = useState('');
    const [memberAddress, setMemberAddress] = useState('');
    const [memberName, setMemberName] = useState('');
    const [memberExpiryDate, setMemberExpiryDate] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        let year = new Date().getFullYear();
        let month = new Date().getMonth()+ 1;
        let day = new Date().getDate();
        let date = year + "-" + month + "-" + day;
        const member = {
            "memberSignupDate": date,
            "membershipType": membershipType,
            "memberAddress": memberAddress,
            "memberName": memberName,
            "memberExpiryDate": memberExpiryDate
        }
        console.log(member);

        try {
            await axios.post('http://localhost:8084/member', member);
            window.alert("Member added successfully!");
        } catch (error) {
            window.alert(error);
        }
        navigate('/members');
    };

    return (
        <>
            <Form autocomplete="off">
                <Form.Group controlId="formMemberName">
                    <Form.Label>Member Name</Form.Label>
                    <Form.Control type="text" placeholder="Enter Member name" onChange={(e) => setMemberName(e.target.value)} />
                </Form.Group>
                <Form.Group controlId="formMemberAddress">
                    <Form.Label >Member Address</Form.Label >
                    <Form.Control type="text" placeholder="Enter Member address" onChange={(e) => setMemberAddress(e.target.value)} />
                </Form.Group>
                <Form.Group controlId="formMembershipType">
                    <Form.Label>Membership Type</Form.Label>
                    <Form.Control type="text" placeholder="Enter Membership Type" onChange={(e) => setMembershipType(e.target.value)} />
                </Form.Group>
                <Form.Group controlId="formMembershipExpiryDate">
                    <Form.Label>Membership Expiry</Form.Label>
                    <Form.Control type="text" placeholder="Enter Expiry Date" onChange={(e) => setMemberExpiryDate(e.target.value)} />
                </Form.Group>
                <Button variant="primary" onClick={handleSubmit}>
                    Submit
                </Button>
            </Form>
        </>
    )
}

export default AddMember;