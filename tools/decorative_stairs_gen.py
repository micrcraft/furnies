import os
import json

# Function to generate the blockstate for decorative stairs
def get_blockstate(wood):
    variants = {}
    # Mapping for connected sides to model suffix
    model_suffix = {
        (False, False): "single",
        (True, False): "left",
        (False, True): "right",
        (True, True): "middle",
    }
    
    # Define facing directions with their rotation (y) values.
    facings = {
        "north": 0,
        "east": 90,
        "south": 180,
        "west": 270
    }
    
    for facing, rotation in facings.items():
        for (conn_left, conn_right), suffix in model_suffix.items():
            key = f"facing={facing},connected_left={str(conn_left).lower()},connected_right={str(conn_right).lower()}"
            variant = {
                "model": f"furnies:block/decorative_stairs/{wood}_{suffix}"
            }
            # Only add rotation if not north (rotation 0)
            if rotation:
                variant["y"] = rotation
            variants[key] = variant

    return {"variants": variants}

# Function to generate a block model for a given stair variant
def get_block_model(wood, variant):
    # variant should be one of: "single", "left", "right", "middle"
    return {
        "parent": f"furnies:block/template/decorative_stairs_{variant}",
        "textures": {
            "1": f"furnies:block/decorative_stairs/{wood}"
        }
    }

# Function to generate the item model for decorative stairs
def get_item_model(wood):
    return {
        "parent": f"furnies:block/decorative_stairs/{wood}_single"
    }

# Function to save JSON data to a file
def save_json_file(path, data):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, "w", encoding="utf-8") as f:
        json.dump(data, f, indent=4)

# Main function to generate files for each wood type
def generate_files():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    woods_file = os.path.join(script_dir, "woods.json")

    with open(woods_file, "r", encoding="utf-8") as f:
        woods = json.load(f)

    # Base directory for your furnies folder structure
    base_dir = os.path.join(script_dir, "furnies")

    for wood in woods:
        # Generate blockstate file
        blockstate_path = os.path.join(base_dir, f"blockstates/{wood}_decorative_stairs.json")
        save_json_file(blockstate_path, get_blockstate(wood))

        # Generate block models for each variant
        for variant in ["single", "left", "right", "middle"]:
            block_model_path = os.path.join(base_dir, f"models/block/decorative_stairs/{wood}_{variant}.json")
            save_json_file(block_model_path, get_block_model(wood, variant))

        # Generate item model file
        item_model_path = os.path.join(base_dir, f"models/item/{wood}_decorative_stairs.json")
        save_json_file(item_model_path, get_item_model(wood))

if __name__ == "__main__":
    generate_files()
