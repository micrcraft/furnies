import os
import json

# Generate the lamp blockstate for a given color
def get_lamp_blockstate(color):
    variants = {}
    # UP facing (ceiling/floor) variants:
    variants["facing=up,base=true,lit=true"] = {"model": f"furnies:block/lamp/{color}"}
    variants["facing=up,base=true,lit=false"] = {"model": f"furnies:block/lamp/{color}_off"}
    variants["facing=up,base=false,lit=true"] = {"model": f"furnies:block/lamp/{color}_tall_top"}
    variants["facing=up,base=false,lit=false"] = {"model": f"furnies:block/lamp/{color}_tall_top_off"}

    # Horizontal (wall) variants:
    facings = {
        "north": 0,
        "east": 90,
        "south": 180,
        "west": 270
    }
    for facing, rotation in facings.items():
        for base in [True, False]:
            for lit in [True, False]:
                key = f"facing={facing},base={'true' if base else 'false'},lit={'true' if lit else 'false'}"
                # For walls, regardless of 'base', use the wall model.
                model_name = f"{color}_wall" if lit else f"{color}_wall_off"
                variant = {"model": f"furnies:block/lamp/{model_name}"}
                # Only add rotation if facing is not north.
                if facing != "north":
                    variant["y"] = rotation
                variants[key] = variant

    return {"variants": variants}

# Generate the lamp connector blockstate (content remains the same regardless of color)
def get_lamp_connector_blockstate():
    return {
        "variants": {
            "base=true": {
                "model": "furnies:block/template/lamp_tall_bottom"
            },
            "base=false": {
                "model": "furnies:block/template/lamp_tall_middle"
            }
        }
    }

# Generate a block model for a given lamp variant.
# The variant suffix should be one of: "", "_off", "_tall_top", "_tall_top_off", "_wall", or "_wall_off"
def get_lamp_model(color, variant_suffix):
    return {
        "parent": f"furnies:block/template/lamp{variant_suffix}",
        "textures": {
            "2": f"furnies:block/lamp/{color}"
        }
    }

# Generate the item model for the lamp
def get_lamp_item_model(color):
    return {
        "parent": f"furnies:block/lamp/{color}"
    }

# Save JSON to a file, ensuring the directories exist
def save_json_file(path, data):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, "w", encoding="utf-8") as f:
        json.dump(data, f, indent=4)

# Main function to generate lamp files for each color in colors.json
def generate_files():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    colors_file = os.path.join(script_dir, "colors.json")

    with open(colors_file, "r", encoding="utf-8") as f:
        colors = json.load(f)

    # Base directory for the output (adjust if needed)
    base_dir = os.path.join(script_dir, "furnies")

    for color in colors:
        # ---------------------------
        # 1. Blockstates
        # ---------------------------
        # Lamp blockstate file (e.g., light_blue_lamp.json)
        lamp_bs_path = os.path.join(base_dir, f"blockstates/{color}_lamp.json")
        save_json_file(lamp_bs_path, get_lamp_blockstate(color))

        # Lamp connector blockstate file (the content is static)
        lamp_conn_bs_path = os.path.join(base_dir, f"blockstates/{color}_lamp_connector.json")
        save_json_file(lamp_conn_bs_path, get_lamp_connector_blockstate())

        # ---------------------------
        # 2. Block Models
        # ---------------------------
        # Define the variants and their corresponding file suffixes.
        # The key is the file name suffix (which is appended to the color),
        # and the value is the variant suffix for the parent in the model JSON.
        lamp_variants = {
            "": "",                 # e.g., light_blue.json
            "_off": "_off",         # e.g., light_blue_off.json
            "_tall_top": "_tall_top",             # e.g., light_blue_tall_top.json
            "_tall_top_off": "_tall_top_off",     # e.g., light_blue_tall_top_off.json
            "_wall": "_wall",       # e.g., light_blue_wall.json
            "_wall_off": "_wall_off"  # e.g., light_blue_wall_off.json
        }

        for file_suffix, variant_suffix in lamp_variants.items():
            model_path = os.path.join(base_dir, f"models/block/lamp/{color}{file_suffix}.json")
            save_json_file(model_path, get_lamp_model(color, variant_suffix))

        # ---------------------------
        # 3. Item Model
        # ---------------------------
        # Item model file for the lamp (e.g., light_blue_lamp.json)
        item_model_path = os.path.join(base_dir, f"models/item/{color}_lamp.json")
        save_json_file(item_model_path, get_lamp_item_model(color))

if __name__ == "__main__":
    generate_files()
