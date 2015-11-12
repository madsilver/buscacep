<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Busca CEP - Home</title>
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/js/jquery-1.11.3.min.js" var="jQuery" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
<link href="${bootstrapCss}" rel="stylesheet" />
<script src="${jQuery}"></script>
<script src="${bootstrapJs}"></script>

</head>
<body>

<div class="container">
	<h2>Cadastro de endereço</h2>
	<p><a href="/buscacep/listAddress">Endereços cadastrados</a></p>  
		<div class="row"> 
			<div class="span12">
				<fieldset>
				<form:form class="form-horizontal" method="post" action="saveAddress" commandName="address">
					<form:hidden path="id"/>
					<div class="control-group">
						<label class="control-label">CEP*</label>
						<div class="controls">
							<form:input path="zipcode" maxlength="8" class="required"/>
							<button type="button" class="btn btn-primary" id="btnZipCode">Consultar</button>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Rua*</label>
						<div class="controls">
							<form:input path="street" class="required"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Número*</label>
						<div class="controls">
							<form:input path="number" class="required"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Complemento</label>
						<div class="controls">
							<form:input path="complement"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Bairro</label>
						<div class="controls">
							<form:input path="neighborhood"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Cidade*</label>
						<div class="controls">
							<form:input path="city" class="required"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Estado*</label>
						<div class="controls">
							<form:input path="state" class="required"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">(*) Campos obrigatórios</label>
					</div>
					<div class="form-actions">
						<button type="submit" class="btn btn-success">Submit</button>
						<button type="button" class="btn" id="btnCancel">Cancel</button>
					</div>
				</form:form>
				</fieldset>
			</div>
		</div>
	</div>	
	<!-- Using REST URL-->
    <!--script src="http://localhost:8080/buscacep/findAddress?callback=functionCall" type="application/javascript"> </script-->
    
	<script type="text/javascript">
	$( document ).ready(function() {
		
	    $('#btnZipCode').click(function(){
	    	var zipcode = $('#zipcode').val();
			$.ajax({
				url:"http://localhost:8080/buscacep/findAddress",data:{"zipcode":zipcode},async:true,dataType:"json",method:"post",
				success: function(resp){
					if(resp.zipcode != null){
						$.each(resp, function(k,v){
							$('#'+k).val(v);
						});
					}
					else{
						alert("CEP inválido");
					}
				}
			});
		});

		$('#btnCancel').click(function(){
			$('form').each (function(i, e){
				//if(e.tagName == "INPUT")
				  	e.reset();
			});
		});
		
		$('form').submit(function(e){
			if($('.required').val() == ""){
				e.preventDefault();
				alert("Preencha os campos obrigatórios");
			}
		});
		
	});
     
	</script>

</body>
</html>