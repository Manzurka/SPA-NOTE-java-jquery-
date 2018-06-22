$(document).ready(function(){
    $.get('/notes', function showall(all_notes){
        console.log(all_notes);
        for(var i=0; i < all_notes.length; i++){
             var html_str= `
               <div class="notes" id="${all_notes[i].id}">
                   <h2>${all_notes[i].title}</h2>
                   <p>${all_notes[i].description}</p>
                   <form class="update" action="/notes/${all_notes[i].id}/update" method="post">
                   </form>
                   <button id="edit">Edit</button>
                   <form class="delete" action="/notes/${all_notes[i].id}/delete" method="post">
                   	<button id="delete">Delete</button>
                   </form>
                   
               </div>
               `;
             $('#all_notes').append(html_str);
      
        }
        
        $('.notes').on("click", "#edit", function(note){
     	   var desc = $(this).siblings()[1].innerHTML;
     	   $(this).parent().find('p').remove();    
     	   
            var html_str =` 
                <textarea name="description">`+desc+`</textarea>
                <button id="update">Update</button>
            `;
            $(this).parent().find('form:first').append(html_str);
            $(this).remove(); 
     })
       
     	$('#delete').click( function(res){
     			$(this).parent().remove(); 
     			showall();
     	}, 'json');
     
    }, 'json')
    

    
     $('.new').submit(function(){
         
     $.post('/notes/create', $(this).serialize(), function(note){
             var html_str= `
               <div class="notes" id="${note.id}">
                       <h2>${note.title}</h2>
                       <p>${note.description}</p>
                       <form action="/notes/${note.id}/update" method="post">
                         
                       </form>
                       <button id="edit">Edit</button>
                       <form class="update" action="/notes/${note.id}/delete" method="post">
                   	   <button id="delete">Delete</button>
                   	   </form>
               </div>
               `;
           $('#all_notes').append(html_str);
           
           resetData();
           
         }, 'json')
         
          return false;
     })
     
     function resetData(){
       	$("#title").val("");
       	$("#desc").val("");
       }
    
     
     $('.update').submit(function(){

	     $.post('/notes/{id}/update', $(this).serialize(), function(res){
	    	 if(res.status == "Done") {
	    	  
	           var html_str= `
	             <div class="notes" id="${res.data.id}">
	                     <h2>${res.data.title}</h2>
	                     <p>${res.data.description}</p>
	                     <form action="/notes/${res.data.id}/update" method="post">
	                       
	                     </form>
	                     <button id="edit">Edit</button>
	                     <button id="delete">Delete</button>
	             </div>
	             `;
	         $(this).parent().html(html_str);
	    	 } else {
	    		 $(div).html("<strong>Error</strong>");
	    	 }
    	 	 

         }, 'json')
         
          return false;
     })
     

    });