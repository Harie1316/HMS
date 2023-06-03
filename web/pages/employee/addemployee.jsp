
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../headers.jsp" %>
<div class="container">
    <div class="row">
        <div class="col">
            <h3>Add Employee</h3>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col" hidden>
            <div>
                <label>ID:</label>
                <input type="text" class="form-control" id="id" value="<%=request.getParameter("id")%>">
            </div>
        </div></div>
        <div class="col-lg-3 col-md-6">
            <div>
                <label>Name:</label>
                <input type="text" class="form-control" id="name">
            </div>
        </div>
        <div class="col-lg-3 col-md-6">
            <div>
                <label>Age:</label>
                <input type="text" class="form-control" id="age">
            </div>
        </div>
        <div class="col-lg-3 col-md-6">
            <div>
                <label>Gender:</label>
                <select class="form-control" id="gender">
                    <option value="">Select</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </div>
        </div>
    
    <div class="row mt-5">
        <div class="col-lg-3 col-md-6">
            <div>
                <label>Email:</label>
                <input type="email" class="form-control" id="email"   >
            </div>
        </div></div>
        <div class="col-lg-3 col-md-6">
            <div>
                <label>Phone:</label>
                <input type="number" class="form-control" id="phone">
            </div>
        </div>
        <div class="col-lg-3 col-md-6">
            <div>
                <label>Address:</label>
                <input type="text" class="form-control" id="address">
            </div>
        </div>
    
    <div class="row mt-5">
        <div class="col-lg-3 col-md-6">
            <div>
                <label>Password:</label>
                <input type="password" class="form-control" id="pass">
            </div>
        </div></div>
        <div class="col-lg-3 col-md-6">
            <div>
                <label>Confirm Password:</label>
                <input type="password" class="form-control" id="cpass">
            </div>
        </div>
        <div class="col-lg-3 col-md-6">
            <div>
                <label>Role:</label>
                <select class="form-control" id="role" name="power">
                    <option value="">Select</option>
                    <option value="STAFF">Staff</option>
                    <option value="ADMIN">Admin</option>
                </select>
            </div>
        </div>
    
    <div class="row mt-5">
        
        <div class="col-lg-3 col-md-6-4">
            <div>
                <label>Department:</label>
                <select  id="dept" class="form-control select2 dept" >
                    
                </select>
            </div>
        </div>
        
    </div>
    <div class="row mt-5">
        <div class="col-lg-3 col-md-6">
            
            <button class="btn btn-primary" onclick="saveData()">Submit</button>
        </div>
    </div>
    
</div>


  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script>
  

    function saveData(){
        var data = {
            "id":$('#id').val(),
            "name":$('#name').val(),
            "age":$('#age').val(),
            "email":$('#email').val(),
            "gender":$('#gender').val(),
            "phone":$('#phone').val(),
            "address":$('#address').val(),
            "password":$('#pass').val(),
            "role":$('#role').val(),
            "dept":$('.dept').val(),
            "uname":$('#email').val()
        }
        alert(data['dept'])
        $.ajax({
            url:"/HMS/Employee",
            type:"POST",
            dataType:"json",
            data:data,
            success:function(e){
                console.log(e)
            },
            error:function(e){
                console.log(e)
            }
        })
        window.location.reload()
    }
    
    $.ajax({
        url:"/HMS/EmpOperations?id=<%=request.getParameter("id")%>",
        type:"GET",
        dataType:"json",
        success:function(e){
            console.log(e)
            $('#name').val(e.name)
            $('#age').val(e.age)
            $('#email').val(e.email)
            $('#gender').val(e.gender)
            $('#phone').val(e.phone)
            $('#address').val(e.password)
            $('#pass').val(e.password)
            $('#cpass').val(e.address)
            $('#role').val(e.role)
            $('#dept').val(e.deartment)
            $('#uname').val(e.uname)
        }
    })
    $.ajax({
            url:"/HMS/Department",
            type:"GET",
            dataType:"json",
            success:function(e){
                console.log(e)
                var output = ''
                for(var i=0;i<e.length;i++){
                    output += "<option value='"+e[i]['id']+"'>"+e[i]['deptn']+"</option>"
                }   
                $('.select2').html(output)
            }
        })
  </script>

<%@include file="../footer.jsp" %>