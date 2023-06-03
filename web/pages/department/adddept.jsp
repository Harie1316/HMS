

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../headers.jsp" %>
<div class="container">
    <div class="row">
        <div class="col">
            <h3>Add Department</h3>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col">
            <div class="form-group mt-5" hidden>
                <label>Department ID</label>
                <input type="text" id="id"  class="form-control">
            </div>
            
            <div class="form-group mt-5">
                <label>Department Name:</label>
                <input type="text" id="deptmn" class="form-control">
            </div>
            <div class="form-group mt-5">
                <label>Department Description:</label>
                <textarea id="deptmnd" class="form-control"></textarea>
            </div>
        </div>
    </div>
    <div class="row mt-5">
        <div class="col">
            <button class="btn btn-primary" id="saveData" onclick="addDept()">Save</button>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
    function addDept(){
        var data = {"id":$('#id').val(),"dept":$('#deptmn').val(),"deptd":$('#deptmnd').val()}
        console.log(data)
        $.ajax({
            url:"/HMS/Department",
            type:"POST",
            data:data,
            success:function(e){
                alert("Department Add Successsfully")
                console.log(e)
                $('#deptmn').val('')
                $('#deptmnd').val('')
            }
        })
    }
    $.ajax({
            url:"/HMS/DepartOpt",
            type:"GET",
            dataType:"json",
            data:{"id":'<%=request.getParameter("id")%>'},
            success:function(e){
                console.log(e)
                $('#id').val(e['id'])
                $('#deptmn').val(e['deptn'])
                $('#deptmnd').val(e['deptdesc'])
                $('#saveData').html("Update")
            }
    })
</script>
<%@include file="../footer.jsp" %>


