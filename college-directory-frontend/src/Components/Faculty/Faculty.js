import React from 'react';
import Navbar from './Navbar';
import './Faculty.css';

const Faculty = () => {
  const studentData = [
    { id: 1, name: 'Niveditha', email: 'nivi@example.com', phone: '545012454', year: 'Sophomore' },
    { id: 2, name: 'Bharani', email: 'bha@example.com', phone: '9865320014', year: 'Junior' },
    // Add more student records as needed
  ];

  return (
    <div>
      <Navbar />
      <div className="student-content">
        <h2 style={{marginLeft:"600px", marginTop:"60px"}}>Student Details</h2>
        <table className="student-table">
          <thead>
            <tr>
              <th>Sl. No</th>
              <th>Name</th>
              <th>Email</th>
              <th>Phone Number</th>
              <th>Year</th>
            </tr>
          </thead>
          <tbody>
            {studentData.map((student, index) => (
              <tr key={student.id}>
                <td>{index + 1}</td>
                <td>{student.name}</td>
                <td>{student.email}</td>
                <td>{student.phone}</td>
                <td>{student.year}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Faculty;