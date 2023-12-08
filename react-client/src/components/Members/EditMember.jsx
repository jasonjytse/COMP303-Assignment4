import { React, useEffect } from 'react';
import { Form, Button } from 'react-bootstrap';
import { useState } from 'react';
import axios from 'axios';
import { useNavigate, useLocation } from 'react-router-dom';

const EditMember = () => {
    const location = useLocation();
    const member = location.state.member;

    const [membershipType, setMembershipType] = useState(member.membershipType);
    const [memberAddress, setMemberAddress] = useState(member.memberAddress);
    const [memberName, setMemberName] = useState(member.memberName);
    const [memberExpiryDate, setMemberExpiryDate] = useState(member.memberExpiryDate);
    let navigate = useNavigate();


    const handleSubmit = async (e) => {
        e.preventDefault();

        const member = {
            "memberSignupDate": member.memberSignupDate,
            "membershipType": membershipType,
            "memberAddress": memberAddress,
            "memberName": memberName,
            "memberExpiryDate": memberExpiryDate
        }
        console.log(member);

        try {
            await axios.put('http://localhost:8084/member', member);
            window.alert("Member edited successfully!");
        } catch (error) {
            window.alert(error);
        }
        navigate('/member');
    };


    return (
        <>
            <Form autocomplete="off">
                <Form.Group controlId="formMemberName">
                    <Form.Label>Member Name</Form.Label>
                    <Form.Control type="text" value={memberName} onChange={(e) => setMemberName(e.target.value)} />
                </Form.Group>
                <Form.Group controlId="formMemberAddress">
                    <Form.Label >Member Address</Form.Label >
                    <Form.Control type="text" value={memberAddress} onChange={(e) => setMemberAddress(e.target.value)} />
                </Form.Group>
                <Form.Group controlId="formMembershipType">
                    <Form.Label>Membership Type</Form.Label>
                    <Form.Control type="text" value={membershipType} onChange={(e) => setMembershipType(e.target.value)} />
                </Form.Group>
                <Form.Group controlId="formMembershipExpiryDate">
                    <Form.Label>Membership Expiry</Form.Label>
                    <Form.Control type="text" value={memberExpiryDate} onChange={(e) => setMemberExpiryDate(e.target.value)} />
                </Form.Group>
                <Button variant="primary" onClick={handleSubmit}>
                    Submit
                </Button>
            </Form>
        </>
    )
}

export default EditMember;