import mongoose from "mongoose";
import app from "./app.js"

(
    async () => {
        try {
            await mongoose.connect("mongodb://localhost:27017/exampledb");
            console.log("DB CONNECTED")

            const onListening = () => {
                console.log("Listening on Port 5000")
            }

            app.listen(5000, onListening)

        } catch (error) {
            console.error("error: ", error);
            throw error;
        }
    }
)