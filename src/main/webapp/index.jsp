<head>
    <link rel="stylesheet" href="css/main.css">
    <title>AMV</title>
</head>
<section class="hero flex login">
    <div class="item hero">
        <img src="media/dude.svg">
    </div>

    <div class="item hero">
        <img src="media/logo.png" alt="logo">
        <form action="login" method="get">
            <div>
                <label>Mobilnummer</label>
                <input type="tel" name="phoneNumber" required autofocus>
            </div>
            <div>
                <label>Passord</label>
                <input type="password" name="password" required>
            </div>
            <button class="btn" type="submit" value="login">Logg inn</button>
        </form>
    </div>
</section>