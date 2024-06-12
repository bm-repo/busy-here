function getUserData(username, password) {
  document.cookie = `password=${password}`;

  // Make an AJAX request to the server to get the user's data.
  $.ajax({
    url: '/getUserData',
    method: 'POST',
    data: { query },
    headers: { 'Authorization': btoa(`${username}:${password}`) },
    success: (data) => {
      console.log(data);
    },
    error: (err) => {
      console.error(err); 
    }
  });
}
