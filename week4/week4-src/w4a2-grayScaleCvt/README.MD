Assignment 1: Batch Grayscale
You have learned how to convert an image to grayscale, and how to select and process several images to convert them to grayscale and display them. You also learned how to copy an image and save it with a different filename. Now put this all together in one program that batch processes several images, and creates and saves new images (with new filenames) that are grayscale versions of each image.

More specifically,

Your program should let the user select multiple image files
For each image, create a new image that is a grayscale version of the original image
For each image, save the grayscale image in a new file with the same filename as the original image, but with the word “gray-” in front of the filename. For example, if the original file was named lion.png, the new image would be a grayscale image and be named gray-lion.png.
Hint: Start with the Batch Grayscale program that processes many images, and add in code to save those files with new names.

Assignment 2: Image Inversion
Write a program to create new images that are photographic negatives (or inverted images) of selected images and save these new images with filenames that are related to the original images, such as adding “inverted-” in front of the old filename. In inverting an image, a pixel’s red, blue, and green components are modified to be the exact opposite within the 0 to 255 range. That is, if a pixel’s red, blue, and green values are (34, 198, 240), then that same pixel in the inverted image would have the red, blue and green values of (221, 57, 15). Note that 255 - 34 is 221, 255 - 198 is 57, and 255 - 240 is 15.

For example, see the original and inverted images of Robert.

<img src="https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/T5Olf2IrEeW0Qgq5snzKHQ_1bbc83433d6f3e7abe7875622a66247f_robert.png?expiry=1529884800000&hmac=XsUullaz8YcT54bytYGE_5pyHQuf7rcENhXT9QBTClk">

<img src="https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/WAa7gmIrEeWc0w7793dlBw_78130e3354f7ce5a6d6dcb44acf832f8_robertinv.png?expiry=1529884800000&hmac=bEzrZBIS9JJjk0Sg2rbNA5G_l5_wmN3KVzUdiqezjSc">

Here is another example. The second image below is the inverted image of the first image.

<img src="https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/qJZb9GIrEeWc0w7793dlBw_d0d7273b7b3aedc4f5c8fe80b9bc5319_cat.png?expiry=1529884800000&hmac=X3_SZy2Fr8OX9Hpu2VYettRyk9ClmpPGrHbkbfAJPS8">

<img src="https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/smH9FWIrEeWc0w7793dlBw_a750e351c422636633b3839ee02b1088_catinv.png?expiry=1529884800000&hmac=WWSP3d3KXhXfT6LR3JDh4K-TSkWhWT5kebHeljisRXo">