<h2>Login</h2>

<form action="login" method="post">
    <input type="text" name="email" placeholder="Email"/><br/>
    <input type="password" name="password" placeholder="Password"/><br/>
    <button type="submit">Login</button>
</form>

<p style="color:red;">${error}</p>

<a href="register">Create Account</a>