$(document).ready(function() {
	// .modal-backdrop classes
	$(".modal-fullscreen").on('show.bs.modal', function () {
	  setTimeout( function() {
	    $(".modal-backdrop").addClass("modal-backdrop-fullscreen");
	  }, 0);
	});
	$(".modal-fullscreen").on('hidden.bs.modal', function () {
	  $(".modal-backdrop").addClass("modal-backdrop-fullscreen");
	});
	//clear form action
	$('#btnClear').click(function(){
		$('.form').find('input').val('');
	});
	//list action
	function list(){
		$.ajax({
			url : "users",
			success : function(data) {
				$("tbody").html(createTable(data));
				console.log("List Success..." + data);
			}
		});
	}
	list();
	//delete action
	$('body').on('click', '.label-danger', function(){			
		var othis=$(this);			   	
		$.ajax({  
	          url:"delete/"+$(this).attr("id"),  
	          type:'DELETE',	       
	          success: function(data) {  			    	   			    	 
	        	  othis.parents('tr').remove();
	        	  console.log("Delete Success..." + data);
	          }
		}); 
	});
	//open form add
	$('.btn-add-modal').click(function(){
		$('#btnClear').trigger( "click" );
		$('#btnAdd').html("<i class='fa fa-plus-circle'></i>&nbsp;&nbsp;Add");
		$('.form').find('input').attr('readonly', false);
	});		
	//add action
	$('#btnAdd').click(function(){
		if($(this).html() == '<i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Add'){
			$.ajax({  
		          url:"add",  
		          type:'POST',
		          data: getForm(),
		          contentType: 'application/json;charset=utf-8',	          
		          success: function(data) {
		        	  console.log("Add Success..." + data);
		        	  list();
		          }
		    }); 
		}
		$('.modal-fullscreen').modal('hide');
	});
	//open form update
	$('body').on('click', '.btn-update-modal', function(){	
		$('#btnAdd').html("<i class='fa fa-plus-circle'></i>&nbsp;&nbsp;Update");
		$('.form').find('input').attr('readonly', false);
		setForm($(this).attr("id"));
	});
	//update action
	$('#btnAdd').click(function(){
		if($(this).html() == '<i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Update'){
			$.ajax({  
		          url:"update/"+$('.form').find('input#id').val(),  
		          type:'PUT',
		          data: getForm(),
		          contentType: 'application/json;charset=utf-8',	          
		          success: function(data) {
		        	  //$('tbody').find()
		        	  //alert('update');
		        	  console.log("Update Success..." + data);
		        	  list();
		          }
		    }); 
		}		
		$('.modal-fullscreen').modal('hide');
	});
	//open form show
	$('body').on('click', '.btn-show-modal', function(){		
		$('.form').find('input').attr('readonly', true);
		setForm($(this).attr("id"));
	});
	//search action
	$('.btn-search').click(function(){
		$.ajax({  
	          url:"search/"+$('#type').val()+"/"+$('#keyword').val(),  
	          type:'GET',	       
	          success : function(data) {
	        	  $("tbody").html(createTable(data));
	        	  console.log("Search Success..." + data);
	          },
	          error: function(data){
	        	  alert('error 404 not found');
	          }
		}); 
	});
	//get form
	function getForm(){
		var usrObj = {
			"id":$('.form').find('input#id').val(),
			"username":$('.form').find('input#username').val(),
			"email":$('.form').find('input#email').val(),
			"password":$('.form').find('input#password').val(),
			"birthdate":$('.form').find('input#birthdate').val(),
			"registerdate":$('.form').find('input#registerdate').val(),
			"image":$('.form').find('input#image').val()		
		};
		return JSON.stringify(usrObj);
	}
	//set form
	function setForm(id){
		$.ajax({  
	          url:"show/"+id,  
	          type:'GET',	       
	          success: function(data) {
	        	  $('.form').find('input#id').val(data['RESPONSE_DATA'].id);
	        	  $('.form').find('input#username').val(data['RESPONSE_DATA'].username);
	        	  $('.form').find('input#email').val(data['RESPONSE_DATA'].email);
	        	  $('.form').find('input#password').val(data['RESPONSE_DATA'].password);
	        	  $('.form').find('input#birthdate').val(data['RESPONSE_DATA'].birthdate);
	        	  $('.form').find('input#registerdate').val(data['RESPONSE_DATA'].registerdate);
	        	  $('.form').find('input#image').val(data['RESPONSE_DATA'].image);
	        	  console.log("Show Success..." + data);
	          }
		}); 
	}
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
				   			"<a class='label label-info btn-show-modal' data-toggle='modal' data-target='#modal-fullscreen' id = "+ data['RESPONSE_DATA'][i].id +" style='margin-right: 10px;'>"+
				   				"<i class='fa fa-eye fa-lg'></i> Show </a>"+ 
				   			"<a class='label label-primary btn-update-modal' data-toggle='modal' data-target='#modal-fullscreen' id = "+ data['RESPONSE_DATA'][i].id +"	style='margin-right: 10px;'>"+
				   				"<i class='fa fa-pencil fa-lg'></i> Update </a> "+
				   			"<a class='label label-danger' id = "+ data['RESPONSE_DATA'][i].id +" style='margin-right: 10px;'>"+
				   				"<i class='fa fa-trash-o fa-lg'></i> Delete </a>"+
				   		"</td>"+
				   	"</tr>";
		}
		return str;
	}
});