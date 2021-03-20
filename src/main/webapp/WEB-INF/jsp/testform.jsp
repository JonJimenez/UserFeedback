<html>
<head>

<script src="testform.js">
</script>

</head>

<body>

<h2>Feedback Test Form</h2>

<form name ="feedback "id="feedback" method="post" action="/feedback">
  <label for="user">User:</label><br>
  <input type="text" id="user" name="user" pattern="[a-zA-Z]+"required><br>
  <label for="rating">Rating:</label><br>
  <input type="number" id="rating" name="rating" pattern="[0-5]" required><br>
  <label for="comments">Comment:</label><br>
  <input type="text" id="comments" name="comments" required><br><br>
  <input type="submit" value="Submit" >
</form> 

</body>
</html>