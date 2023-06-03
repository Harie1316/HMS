

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../headers.jsp" %>


<table class="table">
  <thead>
    <tr>
      <th scope="col">Sr No</th>
      <th scope="col">Name</th>
      <th scope="col">Username</th>
      <th scope="col">Phone</th>
      <th scope="col">Email</th>
      <th scope="col">Start Date</th>
      <th scope="col">End Date</th>
      <th scope="col">Reason</th>
      <th scope="col">status</th>
      

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
        url:"/HMS/Leave",
        type:"GET",
        data:{"id":localStorage.getItem("id"),"role":localStorage.getItem("role")},
        dataType:"json",
        success:function(e){
            console.log(e)
            var output =''
            for(var i=0;i<e.length;i++){
                output+=    "<tr>"+
                            "<th scope='row'>"+(i+1)+"</th>"+
                            "<td>"+e[i]['name']+"</td>"+
                            "<td>"+e[i]['uname']+"</td>"+
                            "<td>"+e[i]['uphone']+"</td>"+
                            "<td>"+e[i]['uemail']+"</td>"+
                            "<td>"+e[i]['start_date']+"</td>"+
                            "<td>"+e[i]['end_date']+"</td>"+
                            "<td>"+e[i]['reason']+"</td>"+
                            "<td>"+e[i]['status']+"</td>"+
                            
                            "</tr>"
            }
            console.log(output)
            $('#tbody').html(output)
        }
    })
    

</script>

<%@include file="../footer.jsp" %>