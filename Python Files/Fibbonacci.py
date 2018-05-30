def fib(n):
    if n < 2:
        return n
    return fib(n-1) + fib(n-2)

n = int(input('Which Fibonacci number do you want to find?\n'))
x = fib(n)
print('The %dth Fibonacci number is %d' %(n, x))
