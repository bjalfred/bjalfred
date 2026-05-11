import pygame
from pygame.locals import *


pygame.init()
pygame.mixer.init()

clock=pygame.time.Clock()
WIDTH=480
HEIGHT=800
screen=pygame.display.set_mode((WIDTH,HEIGHT))
BLACK=(0,0,0)
WHITE=(255,255,255)
METEOR_SPAWN= pygame.USEREVENT + 1
FPS=60

#character
PLAYER_SPEED=12
ALIEN= pygame.image.load("player_sprite.png").convert_alpha()
ALIENDEATH=pygame.mixer.Sound("player_dead.ogg")

#meteorload
tMeteor1=pygame.image.load("meteor_tiny_1.png").convert_alpha()
tMeteor2=pygame.image.load("meteor_tiny_1.png").convert_alpha()
sMeteor1=pygame.image.load("meteor_small_1.png").convert_alpha()
sMeteor2=pygame.image.load("meteor_small_2.png").convert_alpha()
mMeteor1=pygame.image.load("meteor_med_1.png").convert_alpha()
mMeteor2=pygame.image.load("meteor_med_2.png").convert_alpha()
bMeteor1=pygame.image.load("meteor_big_1.png").convert_alpha()
bMeteor2=pygame.image.load("meteor_big_2.png").convert_alpha()
bMeteor3=pygame.image.load("meteor_big_3.png").convert_alpha()
bMeteor4=pygame.image.load("meteor_big_4.png").convert_alpha()

#spawn sounds
sound1=pygame.mixer.Sound("spawn_sound_1.ogg")
sound2=pygame.mixer.Sound("spawn_sound_2.ogg")
sound3=pygame.mixer.Sound("spawn_sound_3.ogg")





#dictionaries
SPEED_PATH={"big":10, "med":11, "small":12, "tiny":12}
SOUND_PATH={"sound_1":["spawn_sound_1.ogg"],"sound_2":["spawn_sound_2.ogg"],"sound_3":["spawn_sound_3.ogg"],}
IMAGE_PATH={ "big":["meteor_big_1.png","meteor_big_2.png","meteor_big_3.png","meteor_big_4.png"],
        "med":["meteor_med_1.png","meteor_med_2.png"],
        "small":["meteor_small_1.png","meteor_small_2.png"],
        "tiny":["meteor_tiny_1.png","meteor_tiny_2.png"]}

