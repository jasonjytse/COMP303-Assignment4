import { React, useEffect, useState } from 'react';
import axios from 'axios';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

function Member()  {

    const navigate = useNavigate();
    const [members, setMembers] = useState([]);

    const fetchMembers = async () => {
        try {
            await axios.get('http://localhost:8084/member')
            .then((response) => {
                setMembers(response.data);
            })
        } catch(error) {
            console.log(error);
        }
    }

    const deleteMember = async (e) => {
        await axios.delete(`http://localhost:8084/member/${e.memberId}`)
        .then(() => {
            fetchMembers();
        })
        .catch((error) => {
            console.log(error);
        });
    };

    useEffect(() => {
        fetchMembers();
    }, [members]);

    return (
        <div>
            <table className="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Membership Type</th>
                        <th>Signup Date</th>
                        <th>Expiry Date</th>
                    </tr>
                </thead>
                <tbody>
                    {members.map((member) => (
                        <tr key={member.id}>
                            <td>{member.memberName}</td>
                            <td>{member.memberAddress}</td>
                            <td>{member.membershipType}</td>
                            <td>{member.memberSignupDate}</td>
                            <td>{member.memberExpiryDate}</td>
                            <td>
                                <Button variant="warning" onClick={() => navigate(`/editmember/${member.memberId}`, { state: {member: member}})}>
                                    Edit
                                </Button>
                            </td>
                            <td>
                                <Button variant="danger" onClick={() => deleteMember(member)}>
                                    Remove
                                </Button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <Button onClick={() => navigate('/addmember')}>Add Member</Button>
        </div>
    );
};

export default Member;
