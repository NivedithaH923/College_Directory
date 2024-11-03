import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Login.css';

const Login = () => {
  const navigate = useNavigate();
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [role, setRole] = useState('');
  const [error, setError] = useState('');

  // Static JSON data for testing purposes with all roles
  const mockData = [
    { username: 'Nivi', password: '123', email:'nivi@gmail.com',photo:'nivi.jpg',phone:'56564343445',year:'SOPHOMORE',role: 'STUDENT' }, 
    { username: 'Chethu', password: '456', email:'chethu@gmail.com',photo:'chethu.jpg',phone:'98754343445',year:'SENIOR',role: 'STUDENT' }, 
    { username: 'Nandish', password: '123',email:'nandish@gmail.com',photo:'nandish.jpg',phone:'98653214702', role: 'STUDENT' }, 
    { username: 'Nayana', password: '456',officehours:'8',email:'nayana@gmail.com',photo:'nayana.jpg',phone:'5874590045', role: 'FACULTY_MEMBER' }, 
    { username: 'Prasad', password: '123',email:'prasad@gmail.com',officehours:'10am - 12pm',photo:'prasad.jpg',phone:'8754621975', role: 'FACULTY_MEMBER' }, 
    { username: 'Raj', password: '123',email:'raj@gmail.com',officehours:'1pm - 3pm',photo:'raj.jpg',phone:'78490343445', role: 'FACULTY_MEMBER' }, 
    { username: 'Ram', password: '123',email:'ram@gmail.com',photo:'ramivi.jpg',phone:'9874562310', role: 'ADMINISTRATOR' }, 
    { username: 'Adithya', password: '123', email:'adi@gmail.com',photo:'adi.jpg',phone:'78450043445',role: 'ADMINISTRATOR' }, 
    { username: 'Basavraj', password: '123',email:'basa@gmail.com',photo:'bas.jpg',phone:'875410445', role: 'ADMINISTRATOR' }

  ];

  const handleLogin = () => {
    if (!username || !password || !role) {
      setError('Please fill in all fields.');
      return;
    }

    // Find a match for the entered credentials in mockData
    const user = mockData.find(
      (user) =>
        user.username === username &&
        user.password === password &&
        user.role === role.toUpperCase()
    );

    if (user) {
      // Redirect based on the role
      if (role.toUpperCase() === 'STUDENT') {
        navigate('/student');
      } else if (role.toUpperCase() === 'FACULTY_MEMBER') {
        navigate('/faculty');
      } else if (role.toUpperCase() === 'ADMINISTRATOR') {
        navigate('/administrator');
      }
    } else {
      setError('Invalid credentials or role.');
    }
  };

  return (
    <div className="login-container">
      <div className="column column-left">
        <span className="login">Login</span>

        <div className="username">Username</div>
        <div className="username-input">
          <input 
            type="text" 
            placeholder="Username" 
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
        </div>

        <div className="password">Password</div>
        <div className="password-input">
          <input 
            type="password" 
            placeholder="Password" 
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>

        <div className="role">Role</div>
        <div className="role-select">
          <select value={role} onChange={(e) => setRole(e.target.value)}>
            <option value="" disabled>Select role</option>
            <option value="ADMINISTRATOR">ADMINISTRATOR</option>
            <option value="STUDENT">STUDENT</option>
            <option value="FACULTY_MEMBER">FACULTY_MEMBER</option>
          </select>
        </div>

        <span className="login-btn" onClick={handleLogin}>Login</span>

        {error && <div className="error-message">{error}</div>}
      </div>

      <div className="column column-right">
      <h1 style={{ color: 'darkblue', fontFamily: 'Georgia, serif', fontWeight: 'bold', fontSize: '2.5rem', textAlign:'center' }}>
  GM UNIVERSITY
</h1>

        <h3>
          A transformative journey of intellectual growth, personal discovery, and lifelong friendships.
          It's a place where you shape your future, challenge your limits, and embrace the excitement of new beginnings.
        </h3>  
      </div>
    </div>
  );
};

export default Login;
