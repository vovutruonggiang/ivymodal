document.addEventListener('DOMContentLoaded', () => {
    const colorInput = document.getElementById('colorInput');
    const colorPreview = document.getElementById('colorPreview');
    const colorCode = document.getElementById('colorCode');

    const nameColor = document.getElementById('nameColor');
    const colorCoding = document.getElementById('colorCoding');
    const sizePreview = document.getElementById('sizePreview');

    // Update color preview and code
    colorInput.addEventListener('input', () => {
        const color = colorInput.value;
        colorPreview.style.backgroundColor = color;
        // colorCode.textContent = color;
        colorCoding.value = color
    });

    // Update size preview
    const updateSizePreview = () => {
        const width = nameColor.value;
        const height = colorCoding.value;
    };

    nameColor.addEventListener('input', updateSizePreview);
    colorCoding.addEventListener('input', updateSizePreview);

    // Initial preview setup
    colorInput.dispatchEvent(new Event('input'));
    updateSizePreview();
});