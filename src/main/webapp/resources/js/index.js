$(document).ready(function() {
	$.ajax({
		url : "users",
		success : function(data) {
			$("tbody").html(createTable(data));
		}
	});
	function createTable(data){
		var str = "";
		for (var i = 0; i < data['RESPONSE_DATA'].length; i++) {
			str += 	"<tr>" +
				   		"<td>"+ data['RESPONSE_DATA'][i].id +"</td>"+	
				   		"<td>"+ data['RESPONSE_DATA'][i].username +"</td>"+
				   		"<td>"+ data['RESPONSE_DATA'][i].email +"</td>"+
				   		"<td>"+ data['RESPONSE_DATA'][i].password +"</td>"+
				   		"<td>"+ data['RESPONSE_DATA'][i].birthdate +"</td>"+
				   		"<td>"+ data['RESPONSE_DATA'][i].registerdate +"</td>"+
				   		"<td>"+ data['RESPONSE_DATA'][i].image +"</td>"+
				   		"<td>"+ 
				   			"<a class='label label-info' href='show/"+ data['RESPONSE_DATA'][i].id +"' style='margin-right: 10px;'>"+
				   				"<i class='fa fa-eye fa-lg'></i> Show </a>"+ 
				   			"<a class='label label-primary' href='update/"+ data['RESPONSE_DATA'][i].id +"'	style='margin-right: 10px;'>"+
				   				"<i class='fa fa-pencil fa-lg'></i> Update </a> "+
				   			"<a class='label label-danger' href='delete/"+ data['RESPONSE_DATA'][i].id +"' style='margin-right: 10px;'>"+
				   				"<i class='fa fa-trash-o fa-lg'></i> Delete </a>"+
				   		"</td>"+
				   	"</tr>";
		}
		return str;
	}
});