tip = float(input('What percent tip to you want to give (whole number)\n'))
price = float(input('How much was your meal?\n'))
tip = tip/100
tip += 1
final = price * tip
print('Your final price is %.2f' %final)
