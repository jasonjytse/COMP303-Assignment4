import { React, useEffect, useState } from 'react';
import axios from 'axios';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

function Publisher()  {

    const navigate = useNavigate();
    const [publishers, setPublishers] = useState([]);

    const fetchPublishers = async () => {
        try {
            await axios.get('http://localhost:8084/publisher')
            .then((response) => {
                setPublishers(response.data);
            })
        } catch(error) {
            window.alert(error);
        }
    }

    const deletePublisher = async (e) => {
        await axios.delete(`http://localhost:8084/publisher/${e.publisherId}`)
        .then(() => {
            fetchPublishers();
        })
        .catch((error) => {
            window.alert(error);
        });
    };

    useEffect(() => {
        fetchPublishers();
    }, [publishers]);

    return (
        <div>
            <table className="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Address</th>
                    </tr>
                </thead>
                <tbody>
                    {publishers.map((publisher) => (
                        <tr key={publisher.id}>
                            <td>{publisher.memberName}</td>
                            <td>{publisher.memberAddress}</td>
                            <td>
                                <Button variant="warning" onClick={() => navigate(`/editpublisher/${publisher.publisherId}`, { state: {publisher: publisher}})}>
                                    Edit
                                </Button>
                            </td>
                            <td>
                                <Button variant="danger" onClick={() => deletePublisher(publisher)}>
                                    Remove
                                </Button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <Button onClick={() => navigate('/addpublisher')}>Add Publisher</Button>
        </div>
    );
}

export default Publisher;
