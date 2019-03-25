# Original idea by The Coding Train on YouTube
# and expanded to Python from JavaScript

import pygame
from random import uniform, randrange
import numpy as np

pygame.init()

white = (255,255,255)
gray = (105,105,105)
black = (0,0,0)
red = (255,0,0)
green = (0,255,0)
blue = (0,0,255)

PI = 3.14159265
TAU = 6.28318531

DWIDTH = 800
DHEIGHT = 600

numBoids = 100
FPS = 60
maxSpeed = 4.0
maxForce = 1.0
boidRadius = 5
perceptionRadius = 50
pr2 = perceptionRadius**2

display = pygame.display.set_mode((DWIDTH, DHEIGHT))
pygame.display.set_caption("Flocking")

clock = pygame.time.Clock()

smallfont = pygame.font.SysFont(None, 25)
medfont = pygame.font.SysFont(None, 50)
largefont = pygame.font.SysFont(None, 80)

def polar_to_cart(r, theta):
    x = r * np.cos(theta)
    y = r * np.sin(theta)
    return [x, y]

def cart_to_polar(x, y):
    r = np.sqrt(x**2 + y**2)
    theta = np.arctan2(y, x)
    return [r, theta]

def distance(x1, y1, x2, y2):
    return (((x2 - x1)**2) + ((y2 - y1)**2))

class Boid:
    def __init__(self, pos, vel, acc):
        self.pos = pos
        self.vel = vel
        self.acc = acc

    def draw(self, color):
        pygame.draw.circle(display, color, [int(self.pos[0]), int(self.pos[1])], boidRadius)

    def update(self):
        velXY = polar_to_cart(self.vel[0], self.vel[1])
        self.pos[0] = self.pos[0] + velXY[0]
        self.pos[0] = self.pos[0] % DWIDTH
        self.pos[1] = self.pos[1] + velXY[1]
        self.pos[1] = self.pos[1] % DHEIGHT
        accXY = polar_to_cart(self.acc[0], self.acc[1])
        velXY[0] += accXY[0]
        velXY[1] += accXY[1]
        self.vel = cart_to_polar(velXY[0], velXY[1])
        if self.vel[0] >= maxSpeed:
            self.vel[0] = maxSpeed
            self.acc[0] = 0.0

    def align(self):
        avg = [0.0, 0.0]
        numPercieved = 0
        for other in flock:
            dist = distance(self.pos[0], self.pos[1], other.pos[0], other.pos[1])
            if other != self and dist <= pr2:
                otherVel = polar_to_cart(other.vel[0], other.vel[1])
                avg[0] += otherVel[0]
                avg[1] += otherVel[1]
                numPercieved += 1
        if numPercieved > 0:
            avg[0] /= numPercieved
            avg[1] /= numPercieved
            self.acc = cart_to_polar(avg[0], avg[1])
            self.acc[0] = maxForce


def create_flock(numBoids=0):
    flock = []
    for x in range(0, numBoids):
        flock.append(Boid([randrange(0, DWIDTH), randrange(0, DHEIGHT)],
        [uniform(2.0, maxSpeed), uniform(0.0, TAU)],
        [uniform(0.0, maxForce), uniform(0.0, TAU)]))
    return flock


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

def pause():
    paused = True

    while paused:
        message("PAUSED", red, -DHEIGHT/4, "medium")
        pygame.display.update()
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                quit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_p:
                    paused = False
                elif event.key == pygame.K_q:
                    pygame.quit()
                    quit()
        clock.tick(5)

def main_loop():
    flocking = True

    display.fill(gray)
    while flocking:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                flocking = False
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_p:
                    pause()
        for x in flock:
            x.align()
        for x in flock:
            x.update()
            x.draw(white)
        pygame.display.update()
        for x in flock:
            x.draw(gray)
        pygame.time.delay(5)
        clock.tick(FPS)


flock = create_flock(numBoids)
main_loop()
