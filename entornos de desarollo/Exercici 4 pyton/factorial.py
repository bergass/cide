def factorial(x):#mal definit factorial
    """
    Calculating the factorial of number using recursion

    Parameters:
        x: integer to calculate
    Returns:
        result: Factorial of number

    """
    if x == 1 or x == 0:
        return 1
    result = x * factorial(x - 1)#s'ha de multiplicar no restar
    return result

num = int(input("Enter a number to calculate it factorial: "))#l'entrada ha de ser un sencer

fact = factorial(num)

print(f"The factorial of {num} is {fact}")