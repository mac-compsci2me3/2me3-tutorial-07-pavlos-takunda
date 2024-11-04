package Iterator2;
//use the iterator from article class to display all components in a for loop
//updated to use for each loop rather than directly calling display. now it iterates over each component
public class Client {
    public static void main(String[] args) {
        Article article = new Article();
        Article article2 = new Article();

        Paragraph paragraph1 = new Paragraph("This is the first paragraph of the article.");
        Paragraph paragraph2 = new Paragraph("This is the second paragraph with more details.");

        Picture picture1 = new Picture("image1.jpg");
        Picture picture2 = new Picture("image2.jpg");

        article.addComponent(paragraph1);
        article.addComponent(picture1);

        article2.addComponent(paragraph2);
        article2.addComponent(picture2);

       // article.addComponent(article2);

        for (ArticleComponent component : article) {
            component.display();
        }
    }
}

//iterator means we can traverse through elements in a collection. so we can use iterator abstraction. 