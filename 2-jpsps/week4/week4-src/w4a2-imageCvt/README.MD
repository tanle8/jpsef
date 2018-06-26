# Assignment 2: Image Inversion

Write a program to create new images that are photographic negatives (or inverted images) of selected images and save these new images with filenames that are related to the original images, such as adding "inverted-" in front of the old filename.

- Domain knowledge: In inverting an image, a pixel’s red, blue, and green components are modified to be the exact opposite within the 0 to 255 range. That is, if a pixel’s red, blue, and green values are (34, 198, 240), then that same pixel in the inverted image would have the red, blue and green values of (221, 57, 15). Note that 255 - 34 is 221, 255 - 198 is 57, and 255 - 240 is 15.

For example, see the original and inverted images of Robert.

<img src="https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/T5Olf2IrEeW0Qgq5snzKHQ_1bbc83433d6f3e7abe7875622a66247f_robert.png?expiry=1529884800000&hmac=XsUullaz8YcT54bytYGE_5pyHQuf7rcENhXT9QBTClk">

<img src="https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/WAa7gmIrEeWc0w7793dlBw_78130e3354f7ce5a6d6dcb44acf832f8_robertinv.png?expiry=1529884800000&hmac=bEzrZBIS9JJjk0Sg2rbNA5G_l5_wmN3KVzUdiqezjSc">

Here is another example. The second image below is the inverted image of the first image.

<img src="https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/qJZb9GIrEeWc0w7793dlBw_d0d7273b7b3aedc4f5c8fe80b9bc5319_cat.png?expiry=1529884800000&hmac=X3_SZy2Fr8OX9Hpu2VYettRyk9ClmpPGrHbkbfAJPS8">

<img src="https://d3c33hcgiwev3.cloudfront.net/imageAssetProxy.v1/smH9FWIrEeWc0w7793dlBw_a750e351c422636633b3839ee02b1088_catinv.png?expiry=1529884800000&hmac=WWSP3d3KXhXfT6LR3JDh4K-TSkWhWT5kebHeljisRXo">

## To tackle this problem

1. First think about how to create a new image that is the inverse of another image.
2. Start by solving an example by hand, write down the steps, find patterns and then test the algorithm
3. Then create a new BlueJ class called `BatchInversions`. In this class create a method named `makeInversion` that:
- has one parameter, an image, and
- returns a new image that is the inverse of the original image.
4. Then add another method called `selectAndConvert` to handle the batch processing of files. This method allows the user to select several files and display the images. Test this method to make sure it works.
5. Then modify the `selectAndConvert` method to save each inverted image as a file with a new filename. Use the old filename and append to the front of it "inverted-"

Link to FAQ page for this course: http://www.dukelearntoprogram.com/course2/faq.php

