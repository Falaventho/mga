import math

def main():
    print("This program finds the real solutinos to a quadratic\n")
    
    a, b, c = eval(input("Please enter the coefficients (a, b, c): "))
    discrim = b * b - 4 * a * c
    if discrim < 0:
        print("\nThe equation has no real roots!")
    else:
        discRoot = math.sqrt(discrim)
        root1 = (-b + discRoot) / (2 * a)
        root2 = (-b - discRoot) / (2 * a)
        print("\nThe solutions are:", root1, root2)
    
main()