

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../headers.jsp" %>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Department</th>
      <th scope="col">Email</th>
      <th scope="col">Gender</th>
      <th scope="col">Address</th>
      <th scope="col">Phone</th>
      <th scope="col">Action</th>

    </tr>
  </thead>
  <tbody id="tbody">
    <tr>
      <th scope="row">1</th>
      <td>Otto</td>
      <td><img src=""></td>
      <td>Otto</td>
      <td>@mdo</td>
      <td>@mdo</td>
      <td>@mdo</td>
      <td>
          <button id="deleteData" class="btn btn-primary">Update</button>
          <button id="updateData" class="btn btn-secondary">Delete</button>
      </td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Otto</td>
      <td><img src=""></td>
      <td>Otto</td>
      <td>@mdo</td>
      <td>@mdo</td>
      <td>@mdo</td>
      <td>
          <button id="deleteData" class="btn btn-primary">Update</button>
          <button id="updateData" class="btn btn-secondary">Delete</button>
      </td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Otto</td>
      <td><img src=""></td>
      <td>Otto</td>
      <td>@mdo</td>
      <td>@mdo</td>
      <td>@mdo</td>
      <td>
          <button id="deleteData" class="btn btn-primary">Update</button>
          <button id="updateData" class="btn btn-secondary">Delete</button>
      </td>
    </tr>
  </tbody>
</table>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $.ajax({
            url:"/HMS/Employee",
            type:"GET",
            dataType:"json",
            success:function(e){
                var output = ''
                console.log(e)
                for(var i=0;i<e.length;i++){
                    output += "<tr><th scope='row'>"+(i+1)+"</th>"+
                            "<td>"+e[i]['name']+"</td>"+
                            "<td>"+e[i]['deartment']+"</td>"+
                            "<td>"+e[i]['email']+"</td>"+
                            "<td>"+e[i]['gender']+"</td>"+
                            "<td>"+e[i]['address']+"</td>"+
                            "<td>"+e[i]['phone']+"</td>"+
                            "<td>"+
                                "<button onclick=updateData('"+e[i]['id']+"') class='btn btn-primary'>Update</button>"+
                                "<button  onclick=deleteData('"+e[i]['id']+"') class='btn btn-secondary'>Delete</button>"+
                            "</td></tr>"
                }
                $('#tbody').html(output)
                 console.log(output)
            },
            error:function(e){
                
            }
           
        })
        
        
        function deleteData(id){
            
            $.ajax({
                url:"/HMS/EmpOperations",
                type:"POST",
                data:{"id":id},
                success:function(e){
                    alert(e)
                    window.location.reload()
                }
                
            })
        }
        function updateData(id){
            alert(id)
            window.location.href="/HMS/pages/employee/addemployee.jsp?id="+id
        }
</script>
<%@include file="../footer.jsp" %>