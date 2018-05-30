answer = input('Can I help you? (Y/N)\n')
x = 4
y = 4
moves = 0
direct = ''
if answer == 'Y' or 'y':
    print('Print menu:')
    print('Enter "1" if you want to jump')
    print('Enter "2" if you want to fall')
    print('Enter "3" if you want to go forward')
    print('Enter "4" if you want to step back')
    while((x >= 0 and x <= 8) and (y >= 0 and y <= 8)):
        print('You are at (%d, %d)' %(x, y))
        direct = input('\n')
        if direct == '1':
            y += 1
            moves += 1
        elif direct == '2':
            y -= 1
            moves += 1
        elif direct == '3':
            x += 1
            moves += 1
        elif direct == '4':
            x -= 1
            moves += 1
        else:
            print('Invalid move!');
elif answer == 'N' or 'n':
    print('Okay have a good day then!')
else:
    print('... what??')
print('You took %d moves' %moves)
