// Fetch the student's name and subject from localStorage (after registration)
let studentName = localStorage.getItem("studentName");
let selectedSubject = localStorage.getItem("selectedSubject");

// Populate dashboard with student data
document.getElementById("studentName").textContent = studentName ? studentName : "Unknown";
document.getElementById("selectedSubject").textContent = selectedSubject ? selectedSubject : "No subject selected";

// Start Preliminary Exam
document.getElementById("startExam").addEventListener("click", function() {
    document.getElementById("examSection").style.display = "block";
});

// Handle Exam Submission
document.getElementById("examForm").addEventListener("submit", function(e) {
    e.preventDefault();

    // Collect the form data
    let q1 = parseInt(document.getElementById("q1").value);
    let q2 = document.getElementById("q2").value.toLowerCase();
    let q3 = parseInt(document.getElementById("q3").value);
    let q4 = document.getElementById("q4").value.toLowerCase();
    let q5 = parseInt(document.getElementById("q5").value);

    // Check the answers
    let score = 0;
    if (q1 === 12) score++;
    if (q2 === "new delhi") score++;
    if (q3 === 8) score++;
    if (q4 === "shakespeare") score++;
    if (q5 === 100) score++;

    // Display result
    let result = `You scored ${score} out of 5`;
    document.getElementById("examResult").textContent = result;
});
