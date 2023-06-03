<%-- 
    Document   : apply
    Created on : 3 Apr, 2022, 12:47:12 AM
    Author     : Ruler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../headers.jsp" %>

<div class="container">
    <div class="row">
        <div class="col">
            <h3>Apply Leave</h3>
        </div>
    </div>
</div>



<div class="container mt-3">
    <div class="row">
        <div class="col" hidden="">
            <div>
                <label>ID:</label>
                <input type="text" class="form-control" id="id">
            </div>
        </div>
    </div>
        <div class="col-lg-3 col-md-6">
            <div>
                <label>Username:</label>
                <input type="text" class="form-control" id="name">
            </div>
        </div>
        <div class="col-lg-3 col-md-6">
            <div>
                <label>Email:</label>
                <input type="email" class="form-control" id="email">
            </div>
        </div>
    
    <div class="col-lg-3 col-md-6">
        <div class="col">
            <div>
                <label>Phone:</label>
                <input type="text" class="form-control" id="phone">
            </div>
        </div>
         </div>
        <div class="col-lg-3 col-md-6">
            <div>
                <label>Leave Type:</label>
                <select class="form-control" id="select-leave">
                    <option>Select Leave</option>
                    <option>Casual Leave</option>
                    <option>Medical Leave</option>
                    <option>Other</option>
                </select>
            </div>
        </div>
   
    <div class="col-lg-3 col-md-6">
        <div class="col">
            <div>
                <label>Start Date:</label>
                <input type="date" class="form-control" id="sdate">
            </div>
        </div>
         </div>
        <div class="col-lg-3 col-md-6">
            <div>
                <label>End Date:</label>
                <input type="date" class="form-control" id="edate">
            </div>
        </div>
    
    <div class="col-lg-3 col-md-6">
        <div class="col">
            <div>
                <label>Reason:</label>
                <input type="text" style:"width=100px" class="form-control" id="reason">
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="col-lg-3 col-md-6">
        <div class="col">
            <div>
                <center> <button class="btn btn-primary" id="saveLeave" onclick="applyleave()">Save</button></center>
                    
            </div>
        </div>
    </div>
    

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
    
    
    $('#id').val(localStorage.getItem("id"))
    $('#name').val(localStorage.getItem("username"))
    $('#email').val(localStorage.getItem("email"))
    $('#phone').val(localStorage.getItem("phone"))
    
    function applyleave(){
        var data ={
            "id" : $('#id').val(),
            "name" : $('#name').val(),
            "email" : $('#email').val(),
            "phone" : $('#phone').val(),
            "leave" : $('#select-leave').val(),
            "sdate" : $('#sdate').val(),
            "edate" : $('#edate').val(),
            "reason" : $('#reason').val()
        }
        $.ajax({
            url:"/HMS/Leave",
            type:"POST",
            data:data,
            dataType:"json",
            success:function(e){
                console.log(e)
                alert("Save")
            }
        })
        window.location.reload()
    }
</script>

<%@include file="../footer.jsp" %>