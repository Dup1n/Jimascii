# Jimascii

It's an implementation about Image-to-ASCII Text converter.

The project is made in:

+ _Java 8_
+ _ImageJ_
+ _Maven_

## How-to-use

Clone the project, in the `Main.java` you change the `imageURL` param for the iamge what you want :

```agsl
    ...
    ASCIIConverter asciiConverter = new ASCIIConverter(imageURL);
    ...
```

We added some images in the `resources` directory if you need test the project.

## Result

### Input (image to test)

![anime girl](./src/main/resources/anime.jpg)

### Output (ASCII text)

![anime girl in ASCII](./src/main/resources/ascii-result.png)