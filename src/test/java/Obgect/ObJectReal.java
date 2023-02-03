package Obgect;

  import org.apache.commons.compress.utils.IOUtils;
  import org.apache.poi.ss.usermodel.*;
  import org.apache.poi.xssf.usermodel.*;
  import org.junit.runners.model.TestClass;
  import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

  import java.io.*;
import java.util.List;



public class ObJectReal extends ObjPage {

    public ObJectReal(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='control-group change-listview']/span[2]")
    private WebElement putAllElem;

    @FindBy(how = How.ID, using = "//div[@class='image_block']/a/img")
    private List<WebElement> colectAllElem;

    @FindBy(xpath = "//h1[@class='prod-name']")
    private WebElement name;

    @FindBy(xpath = "//div[@class='prod-code']")
    private WebElement code;

    @FindBy(xpath = " //span[@id='block_price']")
    private WebElement price;

    @FindBy(xpath = "//div[@class='name']/a")
    private WebElement linkInsideIntoElem;


    @FindBy(xpath = "//div[@class='acord-block acord-description']")
    private WebElement discription;

    @FindBy(xpath = "//div[@class='image_block']/a/img")
    private List<WebElement> linkForClickElement;

    @FindBy(css = ".jshop_img_thumb")
    private List<WebElement> picture;

    @FindBy(xpath = "//div[@class='acord-block acord-equipment']")
    private WebElement complectSet;

    @FindBy(xpath = "//div[@class='acord-block acord-characteristics']")
    private WebElement functionality;



    public WebElement chanView() {
        return putAllElem;
    }

    public List<WebElement> allElements() {
        return colectAllElem;
    }

    public List<WebElement> clickOnElement() {
        return linkForClickElement;
    }

    public WebElement openItem() {
        return linkInsideIntoElem;
    }

    public WebElement productName() {
        return name;
    }

    public WebElement codeItem() {
        return code;
    }

    public WebElement priceItem() {
        return price;
    }

    public List<WebElement> picturesItem() {
        return picture;
    }

    public WebElement descriptionItem() {
        return discription;
    }

    public WebElement functionalityItem() {
        return functionality;
    }

    public WebElement includeItem() {
        return complectSet;
    }


    public ObJectReal allTwelvElem() {
        ObJectReal page = new ObJectReal(driver);
        page.chanView().click();
        return this;
    }

    public ObJectReal grabItems() throws IOException, InterruptedException {
        ObJectReal page = new ObJectReal(driver);
        page.allElements();
        List<WebElement> listOfElem = clickOnElement();
        listOfElem.size();
        System.out.println(listOfElem.size());
        for (int i = 0; i < listOfElem.size(); i++) {
            clickOnElement().get(i).click();
            page.getDataFromElement();
            //driver.navigate().back();
            //i++;
        }
        return this;
    }


    public ObJectReal getDataFromElement() throws IOException {

        // write data into excell
        //Create an object of File class to open xls file
        File file = new File("/Users/vitas-1984/Desktop/DIN1.xlsx");
         try (XSSFWorkbook wb = new XSSFWorkbook()) {
            XSSFSheet sheet = wb.createSheet("DIN1");
            //Cell size
            sheet.setColumnWidth(0,8000);
            sheet.setColumnWidth(1,2000);
            sheet.setColumnWidth(2,2000);
            sheet.setColumnWidth(3,20000);
            sheet.setColumnWidth(4,20000);
            sheet.setColumnWidth(5,4000);
            //Cell style
             CellStyle style = wb.createCellStyle();
             style.setAlignment(HorizontalAlignment.FILL);
             style.setVerticalAlignment(VerticalAlignment.CENTER);
             style.setAlignment(HorizontalAlignment.JUSTIFY);
             style.setBorderBottom(BorderStyle.THICK);
             style.setBottomBorderColor(IndexedColors.BLUE.getIndex());
             style.setBorderLeft(BorderStyle.DOUBLE);
             style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
             style.setBorderRight(BorderStyle.HAIR);

             Row row = sheet.createRow((short) 0);
             row.setHeight((short) 10000);


             Cell cell1 = row.createCell(0);
             cell1.setCellStyle(style);
             cell1.setCellValue(productName().getText());
             Cell cell2 = row.createCell(1);
             cell2.setCellStyle(style);
             cell2.setCellValue(codeItem().getText());
             Cell cell3 = row.createCell(2);
             cell3.setCellStyle(style);
             cell3.setCellValue(priceItem().getText());
             Cell cell4 = row.createCell(3);
             cell4.setCellStyle(style);
             cell4.setCellValue(descriptionItem().getAttribute("innerText"));
             Cell cell5 = row.createCell(4);
             cell5.setCellStyle(style);
             cell5.setCellValue(functionalityItem().getAttribute("innerText"));
             Cell cell6 = row.createCell(5);
             cell6.setCellStyle(style);
             cell6.setCellValue(includeItem().getAttribute("innerText"));
             InputStream is = new FileInputStream((File) picturesItem());
             byte[] bytes = IOUtils.toByteArray(is);
             int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);

             try (FileOutputStream fileOut = new FileOutputStream(file)) {
                wb.write(fileOut);
            }
        }
        return this;
    }
}




