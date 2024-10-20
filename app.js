document.getElementById('registrationForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    let name = document.getElementById('name').value;
    let subject = document.getElementById('subject').value;
    
    // Simulate a backend response by updating the result area
    let resultDiv = document.getElementById('result');
    resultDiv.className = 'result-message success';
    resultDiv.innerHTML = `Registration successful for ${name} with subject ${subject}`;
    resultDiv.style.display = 'block';
});
