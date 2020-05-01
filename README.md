#"=== Readme - Magic Eye Generator v1.0 ==="

##== By:  
msg (msg-programs)

##== What:  
A program to generate autostereograms aka magic eye images from two images.

##== Needed:  
Java >=8  
Tested with Java 8 as shipped with the current Minecraft Launcher and JDK 13.

##== Usage:  
1. Select "texture", the repeatng pattern as seen normally. Preferrably a tileable image
2. Select "depth map", the image to appear. Generated image will be the size of this image.
3. Enter scale of texture as float. Bigger number = smaller scale, since downscaling is more often used. 
	Texture should be repeated a good numebr of times.
4. Enter displacement as int. Bigger number = more displacement, causing the depth effect to be more intense.
	 In practise, numbers between 10 and 40 are best to use. "Smearing" occurs when displacement is too big, breaking the illusion.
5. Enter contrast modifier. Bigger number = more contrast. Makes depth differences more extreme.
	Values too big may cause staggering and delete detail in very bright/dark areas.
6. Check box if your depth map uses white as far and black as near, as the program assumes this to be the other way around.
7. Click render to update display. 
8. Adjust values until image can be seen and recognised clearly.
9. Save image using the button. Image will be saved as a number in the same directory as the jar.

##== Generated files:  
Image will be saved as with a number as the name in the same directory as the jar.

##== Final notes:
On Java 8, UI might be small on hi-res displays.
Display frame close button is disabled, close program using the button on the settings panel frame.