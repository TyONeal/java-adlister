<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Pizza Order</title>
</head>
<body>

<h1>Order a pizza!</h1>

<form method="post" action="/pizza-order">
    <label for="crust-select">Select your crust!</label>
    <select name="crustSelect" id="crust-select">
        <option value="thin">Thin</option>
        <option value="stuffed">Stuffed</option>
        <option value="thick">Thick</option>
    </select>

    <label for="sauce-select">Select your sauce!</label>
    <select name="sauceSelect" id="sauce-select">
        <option value="red">Red</option>
        <option value="spicy-red">Spicy Red</option>
        <option value="barbecue">Barbecue</option>
    </select>

    <label for="size-select">Select your size!</label>
    <select name="sizeSelect" id="size-select">
        <option value="small">Small</option>
        <option value="medium">Medium</option>
        <option value="large">Large</option>
    </select>

    <fieldset>
        <legend>Choose your toppings!</legend>
        <div>
            <label for="pepperoni-select">Pepperoni</label>
            <input type="checkbox" id="pepperoni-select" name="toppings" value="pepperoni">
        </div>
        <div>
            <label for="cheese-select">Extra Cheese</label>
            <input type="checkbox" id="cheese-select" name="toppings" value="extra-cheese">
        </div>
        <div>
            <label for="mushroom-select">Mushroom</label>
            <input type="checkbox" id="mushroom-select" name="toppings" value="mushrooms">
        </div>
        <div>
            <label for="onions-select">Onions</label>
            <input type="checkbox" id="onions-select" name="toppings" value="onions">
        </div>
        <div>
            <label for="sausage-select">Sausage</label>
            <input type="checkbox" id="sausage-select" name="toppings" value="sausage">
        </div>
        <div>
            <label for="olive-select">Olives</label>
            <input type="checkbox" id="olive-select" name="toppings" value="black-olives">
        </div>
        <div>
            <label for="pepper-select">Green Peppers</label>
            <input type="checkbox" id="pepper-select" name="toppings" value="green-peppers">
        </div>
        <div>
            <label for="pineapple-select">Pineapple</label>
            <input type="checkbox" id="pineapple-select" name="toppings" value="pineapple">
        </div>
        <div>
            <label for="spinach-select">Spinach</label>
            <input type="checkbox" id="spinach-select" name="toppings" value="spinach">
        </div>
        <div>
            <label for="garlic-select">Garlic</label>
            <input type="checkbox" id="garlic-select" name="toppings" value="garlic">
        </div>
    </fieldset>

    <label for="address-select">Where is this pizza going?</label>
    <input type="text" id="address-select" name="address-select">

    <button type="submit">Place Order</button>
</form>
</body>
</html>
