# Assignment-1 : Karatsuba Algorithm
# Square of 20 digit number using divide and conquer method
# Time : O(n^1.58)

def karatsuba(x,y):
    if x < 10:
        return x*y
    else:
        n = len(str(x))
        h = n // 2
        p = 10 ** h
        k = 10 ** n
        a = x // p
        b = x % p
        c = y // p
        d = y % p
        ac = karatsuba(a, c)
        bd = karatsuba(b, d)
        plus = karatsuba(a+b, c+d) - ac - bd
        return ac * k + plus * p + bd


x = input("Enter number: ")
res = karatsuba(int(x), int(x))
print("Square of " + str(x) + ": " + str(res))
