<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reporte de Notas</title>
</head>

<body>
    <div>
        <input type="hidden" id="studentNames" value='<%=request.getAttribute("STUDENT_NAMES")%>'>
        <input type="hidden" id="studentGrades" value='<%=request.getAttribute("STUDENT_GRADES")%>' />
        <canvas id="myChart"></canvas>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <script>
        const ctx = document.getElementById('myChart');
        var studentNames = document.getElementById('studentNames').value;
        var studentGrades = document.getElementById('studentGrades').value;

        new Chart(ctx, {
            type: 'bar',
            data: {
                labels: eval(studentNames),
                datasets: [{
                    label: 'Notas / 10',
                    data: eval(studentGrades),
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    </script>
</body>

</html>