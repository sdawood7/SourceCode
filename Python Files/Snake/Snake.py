import pygame
import random

pygame.init()

white = (255,255,255)
black = (0,0,0)
red = (255,0,0)
blue = (0,0,255)
green = (0,255,0)

DWIDTH = 800
DHEIGHT = 600
snakeSize = 10
FPS = 20
appleSize = 10


display = pygame.display.set_mode((DWIDTH, DHEIGHT))
pygame.display.set_caption("Slither")
icon = pygame.image.load('bigapple.png')
pygame.display.set_icon(icon)

snakeHeadImg = pygame.image.load('snakehead.png')
appleImg = pygame.image.load('apple.png')

clock = pygame.time.Clock()

smallfont = pygame.font.SysFont(None, 25)
medfont = pygame.font.SysFont(None, 50)
largefont = pygame.font.SysFont(None, 80)

def pause():
    paused = True
    message("PAUSED", white, -100, "large")
    message("Press C to continue or Q to quit", white, 25, "small")
    pygame.display.update()
    while paused:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_c:
                    paused = False
                elif event.key == pygame.K_q:
                    pygame.quit()
                    quit()
        clock.tick(5)


def score(score):
    text = smallfont.render("Score: "+str(score), True, white)
    display.blit(text, [5,5])


def appleCoords():
    appleX = random.randrange(0, DWIDTH - snakeSize, snakeSize)
    appleY = random.randrange(0, DHEIGHT - snakeSize, snakeSize)
    return (appleX, appleY)


def snake(snakeSize, snakelist):
    if curDir == "up":
        head = pygame.transform.rotate(snakeHeadImg, 0)
    elif curDir == "left":
        head = pygame.transform.rotate(snakeHeadImg, 90)
    elif curDir == "down":
        head = pygame.transform.rotate(snakeHeadImg, 180)
    elif curDir == "right":
        head = pygame.transform.rotate(snakeHeadImg, 270)
    display.blit(head, (snakelist[-1]))
    for XnY in snakelist[:-1]:
        pygame.draw.rect(display, green, [XnY[0], XnY[1], snakeSize, snakeSize])


def message(msg, color, yDisplace=0, size = "small"):
    if size == "small":
        textSurf = smallfont.render(msg, True, color)
    elif size == "medium":
        textSurf = medfont.render(msg, True, color)
    elif size == "large":
        textSurf = largefont.render(msg, True, color)
    textRect = textSurf.get_rect()
    textRect.center = (DWIDTH/2, DHEIGHT/2 + yDisplace)
    display.blit(textSurf,textRect)

def gameIntro():
    intro = True

    while intro:
        display.fill(black)
        message("Welcome to Snake!", green, -100, "large")
        message("Eat the red apples to grow!", red, -30, "small")
        message("Don't hit yourself or the edges!", white, 0, "small")
        message("Use the arrow keys to move", red, 30, "small")
        message("Press S to start and P to pause", white, 60, "small")
        pygame.display.update()
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_s:
                    intro = False

def gameLoop():
    global curDir
    curDir = "up"
    gameExit = False
    gameOver = False

    lead_x = DWIDTH/2
    lead_y = DHEIGHT/2

    lead_x_change = 0
    lead_y_change = -snakeSize

    snakeList = []
    snakeHead = []
    snakeHead.append(lead_x)
    snakeHead.append(lead_y)
    snakeList.append(snakeHead)

    snakeLength = 1

    apple = appleCoords()

    while not gameExit:

        if gameOver:
            message("Game over", red, -50, "large")
            message("Press C to play again, press Q to quit", white, 50, "small")
            pygame.display.update()
        while gameOver:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    gameExit = True
                    gameOver = False
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_q:
                        gameExit = True
                        gameOver = False
                    if event.key == pygame.K_c:
                        gameLoop()


        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                gameExit = True
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_UP and curDir != "down":
                    lead_x_change = 0
                    lead_y_change = -snakeSize
                    curDir = "up"
                elif event.key == pygame.K_LEFT and curDir != "right":
                    lead_y_change = 0
                    lead_x_change= -snakeSize
                    curDir = "left"
                elif event.key == pygame.K_DOWN and curDir != "up":
                    lead_x_change = 0
                    lead_y_change = snakeSize
                    curDir = "down"
                elif event.key == pygame.K_RIGHT and curDir != "left":
                    lead_y_change = 0
                    lead_x_change = snakeSize
                    curDir = "right"
                elif event.key == pygame.K_p:
                    pause()

        if lead_x >= DWIDTH or lead_x < 0 or lead_y >= DHEIGHT or lead_y < 0:
            gameOver = True

        lead_x += lead_x_change
        lead_y += lead_y_change
        display.fill(black)
        display.blit(appleImg, apple)
        snakeHead = []
        snakeHead.append(lead_x)
        snakeHead.append(lead_y)
        snakeList.append(snakeHead)
        if len(snakeList) > snakeLength:
            del snakeList[0]
        for seg in snakeList[:-1]:
            if seg == snakeHead:
                gameOver = True
        snake(snakeSize, snakeList)

        score((snakeLength-1) * 100)

        pygame.display.update()

        if lead_x >= apple[0] and lead_x < apple[0] + appleSize or \
        lead_x + snakeSize > apple[0] and lead_x + snakeSize <= apple[0] + appleSize:
            if lead_y >= apple[1] and lead_y < apple[1] + appleSize or \
            lead_y + snakeSize > apple[1] and lead_y + snakeSize <= apple[1] + appleSize:
                apple = appleCoords()
                snakeLength += 1




        clock.tick(FPS)


gameIntro()
gameLoop()
