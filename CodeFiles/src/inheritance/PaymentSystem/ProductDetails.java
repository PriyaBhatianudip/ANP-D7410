package CodeFiles.src.inheritance.PaymentSystem;

public class ProductDetails {
    String headers[]={"Product_ID", "Product_Name","Category", "Sales_Price", "Quantity","Status"};
        String[][] products = {
                {"P101", "Laptop", "Electronics", "55000", "15", "Available"},
                {"P102", "Mobile", "Electronics", "25000", "25", "Available"},
                {"P103", "Headphones", "Accessories", "2000", "8", "Out of Stock"},
                {"P104", "Keyboard", "Accessories", "1500", "30", "Available"},
                {"P105", "Mouse", "Accessories", "800", "45", "Available"},
                {"P106", "Monitor", "Electronics", "18000", "12", "Available"},
                {"P107", "Printer", "Electronics", "12000", "10", "Available"},
                {"P108", "Scanner", "Electronics", "9000", "0", "Out of Stock"},
                {"P109", "Webcam", "Accessories", "3500", "18", "Available"},
                {"P110", "Speaker", "Accessories", "4500", "20", "Available"},

                {"P111", "Tablet", "Electronics", "22000", "14", "Available"},
                {"P112", "Smart Watch", "Wearables", "7000", "16", "Available"},
                {"P113", "Power Bank", "Accessories", "1800", "35", "Available"},
                {"P114", "USB Cable", "Accessories", "500", "50", "Available"},
                {"P115", "Charger", "Accessories", "1200", "0", "Out of Stock"},
                {"P116", "Router", "Networking", "3000", "22", "Available"},
                {"P117", "Hard Disk", "Storage", "6000", "9", "Available"},
                {"P118", "SSD", "Storage", "7500", "13", "Available"},
                {"P119", "Pen Drive", "Storage", "900", "40", "Available"},
                {"P120", "Memory Card", "Storage", "700", "0", "Out of Stock"},

                {"P121", "Refrigerator", "Home Appliances", "45000", "6", "Available"},
                {"P122", "Washing Machine", "Home Appliances", "35000", "8", "Available"},
                {"P123", "Microwave Oven", "Home Appliances", "12000", "11", "Available"},
                {"P124", "Air Conditioner", "Home Appliances", "42000", "0", "Out of Stock"},
                {"P125", "Air Cooler", "Home Appliances", "9000", "7", "Available"},
                {"P126", "Electric Kettle", "Kitchen", "1800", "20", "Available"},
                {"P127", "Mixer Grinder", "Kitchen", "4500", "15", "Available"},
                {"P128", "Toaster", "Kitchen", "2200", "0", "Out of Stock"},
                {"P129", "Coffee Maker", "Kitchen", "5500", "10", "Available"},
                {"P130", "Induction Cooktop", "Kitchen", "3000", "18", "Available"},

                {"P131", "Office Chair", "Furniture", "8500", "12", "Available"},
                {"P132", "Study Table", "Furniture", "7000", "9", "Available"},
                {"P133", "Bookshelf", "Furniture", "6000", "0", "Out of Stock"},
                {"P134", "Sofa", "Furniture", "28000", "5", "Available"},
                {"P135", "Dining Table", "Furniture", "22000", "6", "Available"},
                {"P136", "Bed", "Furniture", "30000", "4", "Available"},
                {"P137", "Wardrobe", "Furniture", "18000", "0", "Out of Stock"},
                {"P138", "Table Lamp", "Lighting", "1200", "25", "Available"},
                {"P139", "Ceiling Fan", "Lighting", "3500", "17", "Available"},
                {"P140", "LED Bulb", "Lighting", "250", "60", "Available"},

                {"P141", "Backpack", "Bags", "1800", "20", "Available"},
                {"P142", "Travel Bag", "Bags", "3500", "14", "Available"},
                {"P143", "School Bag", "Bags", "1200", "0", "Out of Stock"},
                {"P144", "Water Bottle", "Lifestyle", "700", "35", "Available"},
                {"P145", "Lunch Box", "Lifestyle", "600", "28", "Available"},
                {"P146", "Notebook", "Stationery", "150", "100", "Available"},
                {"P147", "Ball Pen", "Stationery", "50", "200", "Available"},
                {"P148", "Marker Set", "Stationery", "250", "0", "Out of Stock"},
                {"P149", "Calculator", "Stationery", "800", "30", "Available"},
                {"P150", "Desk Organizer", "Stationery", "450", "25", "Available"}
        };
        public int getProductIndex(String productId)
        {
            for(int r=0;r<products.length;r++)
            {
                if(productId.equals(products[r][0]))
                    return r;
            }
            return -1;
        }
        // Display product information
        static void main(String[] args) {
        ProductDetails pd=new ProductDetails();

        for (int i = 0; i < pd.products.length; i++) {

            for (int j = 0; j < pd.products[i].length; j++) {
                System.out.print(pd.products[i][j] + "\t");
            }

            System.out.println();
        }
    }
}