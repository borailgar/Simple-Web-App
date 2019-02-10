<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


<div class="container">
    Add New Account:
	<form method="POST" action="/add-todo.do">
		<fieldset class="form-group">
			<label>Username *</label> <input name="todo" type="text"
				class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>SaaspassID</label> <input name="category" type="text"
				class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>GroupID</label> <input name="group" type="text"
											 class="form-control" /> <BR />
		</fieldset>
		<input name="add" type="submit" class="btn btn-success" value="ADD" />
	</form>
</div>

<%@ include file="../common/footer.jspf"%>