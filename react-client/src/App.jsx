import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';

import { useState } from 'react'
import './App.css'

import { BrowserRouter as Router, Route, Link, Routes,  } from 'react-router-dom';
import { Navbar, Container, Nav } from 'react-bootstrap';
import  Home from './components/Home.jsx'
import Books from './components/Books.jsx'
import './App.css'
import AddBook from './components/AddBook.jsx';
import EditBook from './components/EditBook.jsx';

function App() {

  return (
    <>
      <Router>
        <Navbar bg="primary" variant="dark">
          <Container>
            <Navbar.Brand as={Link} href="#home">
              Jason Tse (301156315)
            </Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="" defaultActiveKey="/">
                <Nav.Link as={Link} to="/">
                  Home
                </Nav.Link>
                <Nav.Link as={Link} to="/books">
                  Books
                </Nav.Link>
                <Nav.Link as={Link} to="/members">
                  Members
                </Nav.Link>
                <Nav.Link as={Link} to="/publishers">
                  Publishers
                </Nav.Link>
              </Nav>
            </Navbar.Collapse>
          </Container>
        </Navbar>
        <div>
          <Routes>
            <Route index element={<Home />} />
            <Route path="books" element={<Books />} />
            <Route path="/addbook" element={<AddBook />} />
            <Route path="/editbook/:id" element={<EditBook />} />
          {/*<Route path="members" element={<Members />} />
          <Route path="publishers" element={<Publishers />} /> */}
          </Routes>
        </div >
      </Router>
    </>
  )
}

export default App
