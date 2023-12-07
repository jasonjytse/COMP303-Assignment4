import { React, useEffect, useState } from 'react';
import axios from 'axios';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

function Books()  {

    const navigate = useNavigate();
    const [books, setBooks] = useState([]);

    const fetchBooks = () => {
        axios.get('http://localhost:8084/books')
        .then((response) => {
            setBooks(response.data);
        })
        .catch((error) => {
            console.log(error);
        });
    }

    const deleteBook = async (e) => {
        console.log(e);
        await axios.delete(`http://localhost:8084/books/${e.bookId}`)
        .then(() => {
            fetchBooks();
        })
        .catch((error) => {
            console.log(error);
        });
    };

    useEffect(() => {
        fetchBooks();
    }, [books]);

    return (
        <div>

            <table className="table">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Price</th>
                        <th>In Stock</th>
                    </tr>
                </thead>
                <tbody>
                    {books.map((book) => (
                        <tr key={book.id}>
                            <td>{book.bookTitle}</td>
                            <td>{book.bookAuthor}</td>
                            <td>{book.bookPrice}</td>
                            <td>{book.isBookInStock == true ? "Yes" : "No"}</td>
                            <td>
                                <Button variant="warning" onClick={() => navigate(`/editbook/${book.bookId}`, { state: { book: book } })}>
                                    Edit
                                </Button>
                            </td>
                            <td>
                                <Button variant="danger" onClick={() => deleteBook(book)}>
                                    Remove
                                </Button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <Button onClick={() => navigate('/addbook')}>Add Book</Button>
        </div>
    );
};

export default Books;
