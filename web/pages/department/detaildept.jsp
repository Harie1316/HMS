

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../headers.jsp" %>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Description</th>
      <th scope="col">Action</th>

    </tr>
  </thead>
  <tbody id="tbody">
    <tr>
      <th scope="row">1</th>
      <td>Otto</td>
      <td>@mdo</td>
      <td>
          <button id="deleteData" class="btn btn-primary">Update</button>
          <button id="updateData" class="btn btn-secondary">Delete</button>
      </td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Otto</td>
      <td>@mdo</td>
      <td>
          <button id="deleteData" class="btn btn-primary">Update</button>
          <button id="updateData" class="btn btn-secondary">Delete</button>
      </td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Otto</td>
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
            url:"/HMS/Department",
            type:"GET",
            dataType:"json",
            success:function(e){
                console.log(e)
                var output = ''
                for(var i=0;i<e.length;i++){
                    output += "<tr>"+
                            "<th scope='row'>"+(i+1)+"</th>"+
                            "<td>"+e[i]['deptn']+"</td>"+
                            "<td>"+e[i]['deptdesc']+"</td>"+
                            "<td>"+
                                "<button class='btn btn-primary' onclick=updateData('"+e[i]['id']+"')>Update</button>"+
                                "<button class='btn btn-secondary' onclick=deleteData('"+e[i]['id']+"')>Delete</button>"+
                            "</td>"+
                            "</tr>"
                }
                $('#tbody').html(output)
                console.log(output)
            }
        })
        function updateData(id){
            alert(id)
            window.location.href="/HMS/pages/department/adddept.jsp?id="+id
        }
        
        function deleteData(id){
            $.ajax({
                url:"/HMS/DepartOpt",
                type:"POST",
                data:{"id":id},
                success:function(e){
                    alert(e)
                    window.location.reload()
                }
                
            })
        }
</script>

<%@include file="../footer.jsp" %>

