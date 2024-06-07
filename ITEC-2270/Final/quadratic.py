import math
# only computes for values with real roots

def main():
    print("This program finds the real solutinos to a quadratic\n")
    
    a, b, c = eval(input("Please enter the coefficients (a, b, c): "))
    
    discRoot = math.sqrt(b * b - 4 * a * c)
    root1 = (-b + discRoot) / (2 * a)
    root2 = (-b - discRoot) / (2 * a)
    
    print("\nThe solutions are:", root1, root2)

main()