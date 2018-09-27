$(function() {

    $('#tabCourse tbody tr').click(addEnrollACourse);

    function addEnrollACourse() {
        var data = table.row( this ).data();
        var yearCurrent=data[1];
        var semesterCurrent=data[2];
        var idC=data[3];



var isTheSame = 0;
        $("#tb_enrollCourses tr td:nth-child(4)").each(function () {

            var texttocheck = this.innerText.trim();
            if (texttocheck === idC) {
                isTheSame=1;
            }
        });



        if(!isTheSame){
        var enrollACourse = {year: yearCurrent, semester: semesterCurrent,idCourse: idC};
        $.post('coursesEnroll', {enrollACourse: JSON.stringify(enrollACourse)}, processData, "json");
            $(this ).closest('tr').remove();
         }else{
            alert("You are enrolled in this course!");
      }
    }



    var table = $('#tabCourse').DataTable();

    $('#tabCourse tbody').on('tr', function () {
        table.row( this ).data();


    } );



    function processData(data) {
        var td0 = $('<td>').text(data.idEnrollACourse);
        var td1 = $('<td>').text(data.year);
        var td2 = $('<td>').text(data.semester);
        var td3 = $('<td>').text(data.idCourse);
        var tr = $('<tr>').append(td0).append(td1).append(td2).append(td3);
        $('#tb_enrollCourses tbody').append(tr);
    }



});







