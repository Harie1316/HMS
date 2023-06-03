

<%@page import="database.DatabaseConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Welcome</title>
    <script>
        if(localStorage.getItem('username')){
            window.location.href='./pages/dashboard.jsp'
        }
    </script>
  </head>
  <body>
      
      <div class="container mt-5">
          <div class="row text-center">
              <h3 class='col'>Login</h3>
          </div>
          <div class="row mt-3">
              <div class='col-3'></div>
              <div class="col">
                  <div >
                      <label>Username:</label>
                      <input type="text" id="username" class="form-control">
                  </div>
                  <div class="mt-3">
                      <label>Password</label>
                      <input type="password" id="password" class="form-control">
                  </div >
                  <div  class="mt-3">
                      <button class="btn btn-primary" id="login">Login</button>
                  </div>
              </div>
              <div class='col-3'></div>
          </div>
          <div class="row mt-3">
              <div class="col">
                  
              </div>
          </div>
      </div>


    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
           $('#login').click(function(){
            alert()
            var uname = $('#username').val()
            var pass = $('#password').val()
            $.ajax({
                url:"/HMS/Login?uname="+uname+"&pass="+pass,
                type:"GET",
                dataType:"json",
                success:function(e){
                    if(e['username']!==undefined){
                        localStorage.setItem("role",e['role']);
                        localStorage.setItem("username",e['username']);
                        localStorage.setItem("email",e['email']);
                        localStorage.setItem("phone",e['phone']);
                        localStorage.setItem("id",e['id']);
                    }else{
                        alert("Invalid")
                    }
                    window.location.reload()
                },
                error:function(e){
                    console.log(e)
                }
            })
           })
        })
    </script>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    
  </body>
</html>